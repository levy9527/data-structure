# Note: HashMap can be replaced by array.
# However, the charset is unknown, if it's unicode, you may need to allocate large amount of memory for bool list
def is_unique_chars(str):
  dict = {}
  for c in str:
    if c in dict:
      return False
    else:
      dict[c] = 1

  import sys
  #boolean_list = [False] * 128
  #print("Memory usage of boolean_list:", sys.getsizeof(boolean_list), "bytes")
  #print("Memory usage of dictionary:", sys.getsizeof(dict), "bytes")
  return True

if __name__ == '__main__':
  assert is_unique_chars("abcdefghiklmnopqrstuvwxyz1234567890!@#$%^&*()") == True
