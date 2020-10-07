#include <stdio.h>
#include <stdlib.h>

int main(int argc, char* argv[]) {

    if (argc!=2) {
	printf("Incorrect Number of Arguments. Exiting");
	printf("\n");
	return 0;
    }

    char * filename = argv[1];

    FILE * fp;
    char * line = NULL;
    size_t len = 0;
    ssize_t read;

    fp = fopen(filename, "r");
    if (fp == NULL)
        exit(EXIT_FAILURE);

    printf("Reading File %s", filename);
    printf("\n");

    int count = 0;
    while ((read = getline(&line, &len, fp)) != -1) {
        printf("Retrieved line of length %zu :\n", read);
        printf("%s", line);
	if (count==3) {
	  // Segmentation Fault
  	  *(int*)0 = 0;
	} else {
	  count++;
	}
    }

    fclose(fp);
    if (line)
        free(line);

    exit(EXIT_SUCCESS);

}
