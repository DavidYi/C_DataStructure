#include <stdio.h>
#include <ctype.h>

int countVowels (char str[])
{
  int pos, vowel = 0;
  char c;
  int length = 0;
  while (str[length] != '\0'){
    length++;
  }

  for (pos = 0; pos < length; pos++){
    c = str[pos];
    if ((c == 'a') || (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u') || (c == 'A') || (c == 'E') || (c == 'I') || (c == 'O') || (c == 'U'))
      vowel++;
  }
  
  return vowel;
}

int main ()
{
  if (countVowels ("Hello, how are you?") == 7)
    printf ("Passed 1\n");
  else
    printf ("Failed 1\n");

  if (countVowels ("AEIOUaeioubcDF?") == 10)
    printf ("Passed 2\n");
  else
    printf ("Failed 2\n");

  if (countVowels ("qwrtypsdfghjklzxcvbnmQWRTYPSDFGHJKL") == 0)
    printf ("Passed 3\n");
  else
    printf ("Failed 3\n");

  if (countVowels ("") == 0)
    printf ("Passed 4\n");
  else
    printf ("Failed 4\n");

  if (countVowels("Hello") == 2)
    printf ("Passed 5\n");
  else
    printf ("Failed 5\n");

  if (countVowels("What is your name?") == 6)
    printf ("Passed 6\n");
  else
    printf ("Failed 6\n");

  if (countVowels("") == 0)
    printf ("Passed 7\n");
  else
    printf ("Failed 7\n");

  if (countVowels("AeU") == 3)
    printf ("Passed 7\n");
  else
    printf ("Failed 7\n");

  if (countVowels("fgh") == 0)
    printf ("Passed 8\n");
  else
    printf ("Failed 8\n");
}
  
  
  
