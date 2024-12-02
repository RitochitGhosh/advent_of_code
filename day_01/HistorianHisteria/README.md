# Historian Hysteria

## Problem Statement

The **Chief Historian** has gone missing just before Christmas, leaving behind two incomplete lists of historically significant location IDs. The Elvish Senior Historians need help reconciling these lists to determine where the Chief Historian might have gone.

The lists are disorganized and may contain errors, so the goal is to:

### Part 1: Calculate the Total Distance Between the Two Lists
- Pair up the smallest numbers in both lists, the second smallest numbers, and so on.
- Calculate the absolute difference for each pair and sum these differences.

### Part 2: Calculate a Similarity Score
- For each number in the first list, count how many times it appears in the second list.
- Multiply the number by its occurrence count and sum these results for all numbers in the first list.

---

## Approach to Solve

### Step 1: Parse and Prepare Input
- The input file contains two lists of numbers, written as pairs (one number from each list) on each line.
- Parse the input file into two separate lists, `list1` and `list2`.
- Sort both lists to prepare them for pairing (necessary for calculating the total distance).

---

### Step 2: Calculate Total Distance
- Iterate through both sorted lists simultaneously.
- For each pair `(list1[i], list2[i])`, calculate the absolute difference and accumulate the sum.

---

### Step 3: Calculate Similarity Score
- Create a frequency map for the second list (`list2`) to store the count of each number.
- Iterate through the first list (`list1`) and check how many times each number appears in the second list using the frequency map.
- Multiply the number by its occurrence count in the second list and accumulate the result.
