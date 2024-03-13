'''
One Away: There are three types of edits that can be performed on strings:
insert a character, remove a character, or replace a character.
Given two strings, write a function to check if they are one edit (or zero edits) away.
EXAMPLE
pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false
'''
def is_one_away(a: str, b: str) -> bool:
  # runtime is O(N) where N stands for length of string b
  # so the thinking is: comparing two string, and there's only one character different, then return True
  left = 0
  right = -1
  # use two pointers, if meet different, then stop, move the other
  # if get two stops, return False
  stop_count = 0
  for ch in a:
    if a[left] == b[left]:
      left += 1
    else:
      stop_count += 1
      break

  if stop_count == 0:
    return True

  for ch in b:
    if a[right] == b[right]:
      right -= 1
    else:
      stop_count += 1
      break
  # consider length and use the longest one to compare left and right
  str = a
  if len(b) > len(a):
    str = b

  return str[left] == str[right]


if __name__ == '__main__':
  assert True == is_one_away('pale', 'pale')
  assert True == is_one_away('pale', 'ple')
  assert True == is_one_away('pale', 'pales')
  assert False == is_one_away('pale', 'bake')
