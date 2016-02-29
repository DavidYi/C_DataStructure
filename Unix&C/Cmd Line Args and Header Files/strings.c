#include <stdio.h>

int length (char str[])
{
  int i =0;
  while (str[i] != '\0')
    i++;

  return i;
}

int getFile (char s[], int lim)
{
  int c, pos;

  pos = 0;
  c = getchar();

  while ((c != EOF) && (pos < (lim-1)))
  {
    s[pos] = c;
    pos++;
    c = getchar();    
  }
  s[pos] = '\0';

  return pos;
}

int substr (char str[], char srch[])
{
  int i = 0;
  int j = 0;
  int match = 1;
  int strLength = length(str);
  int srchLength = length (srch);

  while (i < strLength - srchLength)
  {
    j = 0;
    match = 1;
    
    while (j < srchLength) {
      if (str[i+j] != srch[j])
      {
	match = 0;
	break;
      }
      j++;
    }

    if (match == 1)
      return i;

    i++;
  }
  return -1;
}

      
