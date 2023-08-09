# Write a program that swaps the values of two numbers
def swap(x, y):
    temp = x
    x = y
    y = temp
    # the line: "x, y = y, x" also works
    print("a = ", x, "and b = ", y)


a = 1
b = 7
print("a = ", a, "and b = ", b)
print("calling swap function...")
swap(a, b)
