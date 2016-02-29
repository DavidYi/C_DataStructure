#include <stdio.h>
#include "strings.h"

int main (int argc, char* argv[])
{
  int i;
  int len;
  int pos;
  char f[5000];
  getFile (f, 5000);

  char *src;

  src = argv[1];
  
  pos = substr (f, src);

  if (pos == -1)
    printf ("Not found!\n");
  else
    printf ("Found at position %d.\n", pos);

  /*  
  printf ("\n\nCommand line arguments are:\n");
  for (i=0; i<argc; i++)
  {
    len = length(argv[i]);
    
    printf ("%d: %s; Length=%d\n", i, argv[i], len);
  }

  printf ("Length: %d\n", length(f));
  */
  
}
  
