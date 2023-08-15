# in a list of n elements, move all instances of '0' to the end of the list

list = [0, 1, 9, 5, 0, 1, 2, 5, 6, 7, 9, 0, 1]

print(list)

for i in list:
    if i == 0:
        list.remove(i)
        list.append(i)
print(list)

# time complexity of O(N)
