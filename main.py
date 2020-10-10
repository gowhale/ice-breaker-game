# Author: gowhale
# Date: 10/10/2020
# This program has functions which generate questions for a scattegory type of game
# I am following the PEP 8 Python coding standards: https://www.python.org/dev/peps/pep-0008/

from random import randrange
import random
import time


# This function will pick a random letter between A-Z
def generate_random_letter():
    index = randrange(26)
    letter = chr(65+index)
    return letter


# This function will select questions from a text file
def select_questions(n):
    topic_file = open("topics.txt").read()
    topics = topic_file.splitlines()
    random_selection = random.sample(topics, n)
    return random_selection


# This function will print out the questions in a nice format
def display_questsions(questions):
    print("The following topics are:")
    for i in range(0, len(questions)):
        print("\t{}) {}".format(i+1, questions[i]))


# This function will print out the randomly selected letter in a nice format
def display_letter(letter):
    print("The letter randomly selected is: {}".format(letter))


# Thid is the main section of code which is fired when the program is excecuted
def main():
    playing_game = True
    while playing_game:

        print("#" * 50)
        print()
        random_letter = generate_random_letter()
        display_letter(random_letter)
        print()

        question_count = -1
        while question_count < 1 or question_count > 10:
            try:
                question_count = int(input(
                    "How many questions would you like to see for the letter {}: ".format(random_letter)))
            except:
                print("INVALID INPUT, please select an integer between 1 and 10.")

        print()
        questions_selected = select_questions(question_count)
        display_questsions(questions_selected)
        print()


if __name__ == "__main__":
    main()
