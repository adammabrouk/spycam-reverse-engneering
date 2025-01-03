import re

# Regex for AWS keys
aws_regex = re.compile(r"(A3T[A-Z0-9]{16}|AKIA[0-9A-Z]{16}|ASIA[0-9A-Z]{16}|ANPA[0-9A-Z]{16})[\s=:]+([A-Za-z0-9/+=]{40})")

# Open file
with open('uncovered_libapp', 'r') as f:
    content = f.read()

# Find matches
matches = aws_regex.findall(content)
for match in matches:
    print(f"Found AWS Key Pair: {match}")
