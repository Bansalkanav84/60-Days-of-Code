import os
import subprocess
import re

def get_latest_day_folder():
    folders = [f for f in os.listdir() if re.match(r"Day\d+", f) and os.path.isdir(f)]
    folders.sort()
    return folders[-1] if folders else None

def count_java_files(folder):
    return len([f for f in os.listdir(folder) if f.endswith(".java")])

def count_total_problems_from_readme(readme_path="README.md"):
    """
    Counts the total number of problems solved so far by parsing the table in README.md.
    """
    if not os.path.exists(readme_path):
        print("❌ README.md not found.")
        return 0

    total = 0
    with open(readme_path, "r", encoding="utf-8") as f:
        for line in f:
            # Match lines like: | ✅ Day 1 |  2 problems | Completed |
            match = re.match(r"\|\s*✅?\s*Day\s+\d+\s*\|\s*(\d+)\s+problems?\s*\|", line)
            if match:
                total += int(match.group(1))
    return total

def update_total_problems_in_readme(readme_path="README.md"):
    """
    Updates or inserts the total problems solved line in the README.md file.
    """
    total = count_total_problems_from_readme(readme_path)
    total_line = f"\n> 🏆 **Total Problems Solved:** {total}\n"

    if not os.path.exists(readme_path):
        print("❌ README.md not found.")
        return

    with open(readme_path, "r", encoding="utf-8") as f:
        lines = f.readlines()

    # Remove any existing total problems line
    new_lines = []
    found = False
    for line in lines:
        if re.match(r"^> 🏆 \*\*Total Problems Solved:\*\* \d+", line):
            if not found:
                new_lines.append(total_line)
                found = True
            # skip old total line
        else:
            new_lines.append(line)
    if not found:
        # Insert after the progress table (after the last table row)
        insert_idx = None
        for i, line in enumerate(new_lines):
            if line.startswith("| ..."):
                insert_idx = i
                break
        if insert_idx is not None:
            new_lines.insert(insert_idx + 1, total_line)
        else:
            # fallback: append at the end
            new_lines.append(total_line)

    with open(readme_path, "w", encoding="utf-8") as f:
        f.writelines(new_lines)

    print(f"🏆 Updated total problems solved in README.md: {total}")

def update_readme(day_folder):
    readme_path = "README.md"
    day_num = re.findall(r"\d+", day_folder)[0]
    problem_count = count_java_files(day_folder)
    new_line = f"| ✅ Day {day_num} |  {problem_count} problems | Completed |\n"

    if not os.path.exists(readme_path):
        print("❌ README.md not found.")
        return

    with open(readme_path, "r", encoding="utf-8") as f:
        lines = f.readlines()

    # Check if the day already exists
    for line in lines:
        if re.search(rf"\|\s*✅?\s*Day\s+{day_num}\b", line):
            print(f"🟡 README already contains Day {day_num}, skipping.")
            return

    # Find last row of the progress table (just before next heading or empty line)
    insert_index = None
    for i in range(len(lines)):
        if lines[i].startswith("|") and "Day" in lines[i]:
            insert_index = i

    if insert_index is not None:
        lines.insert(insert_index + 1, new_line)
    else:
        print("❌ Could not find where to insert the new Day entry.")
        return

    with open(readme_path, "w", encoding="utf-8") as f:
        f.writelines(lines)

    print(f"📘 Updated README.md with Day {day_num} entry.")

def stage_and_commit(paths, message):
    subprocess.run(["git", "add"] + paths, check=True)
    result = subprocess.run(["git", "diff", "--cached", "--quiet"])
    if result.returncode != 0:
        subprocess.run(["git", "commit", "-m", message], check=True)
        print(f"✅ Committed: {message}")
        return True
    else:
        print(f"🟡 No changes to commit for: {message}")
        return False

def main():
    try:
        latest_day = get_latest_day_folder()

        # 1. Update README.md
        if latest_day:
            update_readme(latest_day)
        else:
            print("⚠️ No DayXX folders found.")

        # 2. Update total problems solved in README.md
        update_total_problems_in_readme()

        # 3. Commit DayXX folder
        if latest_day:
            day_num = re.findall(r"\d+", latest_day)[0]
            stage_and_commit([latest_day], f"Day {day_num}: LeetCode solutions")

        # 4. Commit scripts + README
        stage_and_commit(["create_day.py", "git_push.py", "README.md"], "Updated scripts and README")

        # 5. Push all
        subprocess.run(["git", "push"], check=True)
        print("🚀 All changes pushed to GitHub!")

    except subprocess.CalledProcessError:
        print("❌ Git command failed. Please check your Git setup.")

if __name__ == "__main__":
    main()