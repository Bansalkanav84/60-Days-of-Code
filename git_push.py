
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



