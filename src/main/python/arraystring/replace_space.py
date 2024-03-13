'''
Write a method to replace all spaces in a string with '%20'.
You may assume that the string has sufficient space at the end to hold the additional characters,
and that you are given the "true" length of the string.
(Note: If implementing in Java,please use a character array so that you can perform this operation in place.)

EXAMPLE
Input: "Mr John Smith ", 13
Output: "Mr%20John%20Smith"
'''
def replace_space(string: str, length: int):
  # check the input params
  if len(string) < length:
    length = len(string)
  result = []
  # foreach char in string, stop when meet the length
  for ch in string[:length]:
    if ch == ' ':
      # replace space with '%20'
      result.append('%20')
    else:
      # of course, we should do it to form a new string
      result.append(ch)
  # the runtime is O(Min(N, L)) where N is the length of the string, L is the length of the input
  return "".join(result)


if __name__ == '__main__':
    assert "Mr%20John%20Smith" == replace_space("Mr John Smith ", 13)