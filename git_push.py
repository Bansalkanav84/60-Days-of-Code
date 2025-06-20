
import os
import subprocess
import re

def get_latest_day_folder():
    folders = [f for f in os.listdir() if re.match(r"Day\d+", f) and os.path.isdir(f)]
    folders.sort()
    return folders[-1] if folders else None

def count_java_files(folder):
    return len([f for f in os.listdir(folder) if f.endswith(".java")])

def update_readme(day_folder):
    readme_path = "README.md"
    day_num = re.findall(r"\d+", day_folder)[0]
    problem_count = count_java_files(day_folder)
    new_line = f"| ✅ Day {day_num} |  {problem_count} | Completed |\n"

    if not os.path.exists(readme_path):
        print("❌ README.md not found.")
        return

    with open(readme_path, "r", encoding="utf-8") as f:
        lines = f.readlines()

    # Check if the line already exists
    for line in lines:
        if f"| Day {day_num} " in line:
            print(f"🟡 README already contains Day {day_num}, skipping.")
            return

    # Find where to insert (after the table header)
    for i, line in enumerate(lines):
        if re.match(r"\|[- ]+\|[- ]+\|[- ]+\|", line):
            insert_index = i + 1
            break
    else:
        print("❌ Could not locate progress table in README.md")
        return

    lines.insert(insert_index, new_line)

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

        # 2. Commit DayXX folder
        if latest_day:
            day_num = re.findall(r"\d+", latest_day)[0]
            stage_and_commit([latest_day], f"Day {day_num}: LeetCode solutions")

        # 3. Commit scripts + README
        stage_and_commit(["create_day.py", "git_push.py", "README.md"], "Updated scripts and README")

        # 4. Push all
        subprocess.run(["git", "push"], check=True)
        print("🚀 All changes pushed to GitHub!")

    except subprocess.CalledProcessError:
        print("❌ Git command failed. Please check your Git setup.")

if __name__ == "__main__":
    main()
