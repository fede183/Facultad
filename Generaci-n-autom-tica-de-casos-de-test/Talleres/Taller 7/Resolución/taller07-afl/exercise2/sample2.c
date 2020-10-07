#include <stdio.h>
#include <stdlib.h>
#include  <string.h>

int main(int argc, char* argv[])
{
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

    while ((read = getline(&line, &len, fp)) != -1) {
        printf("Retrieved line of length %zu :\n", read);
        printf("%s", line);
	if (strcmp(line,"Hello\n")==0) {
		printf("Hello there!\n");
	} else if (strcmp(line,"How are you?\n")==0) {
		printf("Fine!\n");
	} else if (strcmp(line,"What is your name?\n")==0) {
		printf("My name is Joshua\n");
	} else if (strcmp(line,"Are you a computer?\n")==0) {
		printf("No\n");
	} else if (strcmp(line,"Are you a human?\n")==0) {
		printf("Yes\n");
	} else if (strcmp(line,"Good bye!\n")==0) {
		printf("Bye!\n");
    		exit(EXIT_SUCCESS);		
	} else if (strstr(line, "computer") != NULL) {
		printf("Sample2 ha crasheado...");
		printf("\n");
		// Code for crashing
  	  	*(int*)0 = 0;
	} else {
		printf("Sample2 se ha colgado ...");
		printf("\n");
		// Code for hanging
		while (1) {}
	}
    }

    fclose(fp);
    if (line)
        free(line);

    exit(EXIT_SUCCESS);
}
