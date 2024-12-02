# Safety Report Checker

## Problem Statement

The engineers at the **Red-Nosed reactor** need your help analyzing unusual data to determine which safety reports are considered "safe." Each report consists of a list of numbers called levels, which must meet certain criteria to qualify as safe. Additionally, the **Problem Dampener** can help by tolerating one bad level in an otherwise unsafe report.

### Part 1: Rules for a Safe Report
A report is considered **safe** if:
1. The levels are either all **strictly increasing** or all **strictly decreasing**.
2. The difference between any two adjacent levels is **at least 1** and **at most 3**.

For example:
- `7 6 4 2 1` → **Safe** (strictly decreasing, differences are within range).
- `1 2 7 8 9` → **Unsafe** (difference between `2` and `7` is `5`).
- `9 7 6 2 1` → **Unsafe** (difference between `6` and `2` is `4`).

### Part 2: Problem Dampener
The **Problem Dampener** allows the safety systems to ignore one bad level in an otherwise safe report. This means:
- A report is **safe** if removing **one level** would make it meet the criteria above.

For example:
- `1 3 2 4 5` → **Safe** by removing `3` (remaining levels: `1 2 4 5`).
- `8 6 4 4 1` → **Safe** by removing the second `4` (remaining levels: `8 6 4 1`).

---

## Approach to Solve

### Step 1: Parse Input Data
- Each line in the input file represents a report, with levels separated by spaces.
- Parse the input file into a list of reports, where each report is a list of integers.

---

### Step 2: Check if a Report is Safe
- **Increasing:** Check if the levels are strictly increasing and all adjacent differences are within `[1, 3]`.
- **Decreasing:** Check if the levels are strictly decreasing and all adjacent differences are within `[1, 3]`.

---

### Step 3: Count Safe Reports
1. Iterate through all reports and check if each is safe based on the rules above.
2. Count the total number of safe reports.

---

### Step 4: Handle Problem Dampener
1. For each report:
   - If it is already safe, count it as safe.
   - Otherwise, try removing each level and recheck if the modified report is safe.
2. Count the total number of reports that are safe after applying the Problem Dampener.

---

