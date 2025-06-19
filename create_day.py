import os

day = input("Enter day number (e.g., 10): ").zfill(2)
count = int(input("How many problems today?: "))

folder = f"Day{day}"
os.makedirs(folder, exist_ok=True)

readme_path = os.path.join(folder, "README.md")

with open(readme_path, "w", encoding="utf-8") as readme:
    for i in range(count):
        title = input(f"Problem {i+1} title: ")
        url = input(f"Problem {i+1} LeetCode URL: ")

        filename = title.replace(" ", "_") + ".java"
        open(os.path.join(folder, filename), "w", encoding="utf-8").close()

        readme.write(f"### [{title}]({url})\n")
        readme.write(f"✅ Solution: [{filename}]({filename})\n\n")

print(f"{folder} setup complete ✅")
