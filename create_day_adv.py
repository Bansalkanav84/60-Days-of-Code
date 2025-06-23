import os
import re

def generate_url(title):
    # Lowercase title
    slug = title.lower()
    # Remove common punctuation (parentheses, apostrophes, etc.)
    slug = re.sub(r"[’'\".,:()]", "", slug)
    # Allow letters, digits, hyphens and spaces only
    slug = re.sub(r"[^a-z0-9\- ]+", "", slug)
    # Convert multiple spaces to single dash
    slug = slug.strip().replace(" ", "-")
    return f"https://leetcode.com/problems/{slug}/description/"

day = input("Enter day number (e.g., 10): ").zfill(2)
count = int(input("How many problems today?: "))

folder = f"Day{day}"
os.makedirs(folder, exist_ok=True)

readme_path = os.path.join(folder, "README.md")

with open(readme_path, "w", encoding="utf-8") as readme:
    for i in range(count):
        title = input(f"Problem {i+1} title: ")
        url = generate_url(title)

        # Clean filename: remove special characters except underscores
        filename = re.sub(r"[’'\".,:()]", "", title).replace(" ", "_") + ".java"
        open(os.path.join(folder, filename), "w", encoding="utf-8").close()

        readme.write(f"### [{title}]({url})\n")
        readme.write(f"✅ Solution: [{filename}]({filename})\n\n")

print(f"{folder} setup complete ✅")
