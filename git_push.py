
import subprocess

commit_msg = input("Enter commit message: ").strip()

try:
    subprocess.run(["git", "add", "."], check=True)
    subprocess.run(["git", "commit", "-m", commit_msg], check=True)
    subprocess.run(["git", "push"], check=True)
    print("✅ Code successfully pushed to GitHub!")
except subprocess.CalledProcessError:
    print("❌ Git command failed. Please check your Git setup.")
