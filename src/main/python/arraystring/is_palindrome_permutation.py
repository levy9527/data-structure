'''
Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
A palindrome is a word or phrase that is the same forwards and backwards.
A permutation is a rearrangement of letters.
The palindrome does not need to be limited to just dictionary words.

EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat", "atco eta", etc.)
'''


def gen_permutations(str):
  # to lowercase
  # what the heck, can't write it by myself!
  pass


def is_palindrome_str(permutation: str):
  # use two pointers to move from both sides
  # runtime is O(n)
  left = 0
  right = -1
  while left > right:
    while permutation[left] == ' ':
      left += 1
    while permutation[right] == ' ':
      right -= 1

    if permutation[left] != permutation[right]:
      return False

    left += 1
    right -= 1
  return True


def is_palindrome_permutation_bruce_force(str: str):
  # check str not null
  if len(str) == 0:
    return False
  # notice that letter is case-insensitive and space is not counted in palindrome
  # so the algorithm should go with two steps:
  # 1. generate permutations
  # 2. judge if any of the permutations is palindrome
  permutations = gen_permutations(str) # O(n!) where n is the length of str
  for permutation in permutations:
    if is_palindrome_str(permutation):
      return True
  return False


def is_palindrome(dict: dict) -> bool:
  has_single_value = False
  for v in dict.values():
    if v % 2 == 1:
      if not has_single_value:
        has_single_value = True
      else:
        return False
  return True


def is_palindrome_permutation(str: str) -> bool:
  # the runtime is O(N)
  if len(str) == 0:
    return False
  dict = {}
  for letter in str:
    if letter == ' ':
      continue
    char = letter.lower()
    if char in dict:
      count = dict.get(char)
      count += 1
      dict[char] = count
    else:
      dict[char] = 1
  return is_palindrome(dict)


if __name__ == '__main__':
    assert True == is_palindrome_permutation('Tact Coa')