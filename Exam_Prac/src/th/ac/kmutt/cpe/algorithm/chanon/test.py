import random
import heapq

# Configuration
n = 100000         # number of integers in the test case
min_val = 1      # minimum integer value
max_val = 10000   # maximum integer value
testcase_file = "testcase.txt"
answer_file = "answer.txt"

# Generate random test case
testcase = [random.randint(min_val, max_val) for _ in range(n)]

# Function to calculate the final number using the sum-two-mins method
def sum_two_min(arr):
    heapq.heapify(arr)
    while len(arr) > 1:
        first = heapq.heappop(arr)
        second = heapq.heappop(arr)
        heapq.heappush(arr, first + second)
    return arr[0]

# Compute answer
answer = sum_two_min(testcase.copy())

# Write test case to file
with open(testcase_file, "w") as f:
    f.write(f"{n}\n")
    f.write(" ".join(map(str, testcase)))

# Write answer to file
with open(answer_file, "w") as f:
    f.write(str(answer))

print(f"Test case written to {testcase_file}")
print(f"Answer written to {answer_file}")
