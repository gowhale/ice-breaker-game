# Author: gowhale
# Date: 10/10/2020
# This file has functions which generate questions for a scattegory type of game
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
    random_selection = random.sample(topics, 5)
    return random_selection


# This function will print out the letter selected and the questions to answer
def display_questsions(questions):
    print()


def display_letter(letter):
    print("The letter randomly selected is: {}").format(letter)

# while 1:
#     time.sleep(1)
#     print(generate_random_letter())
#     print(select_questions(5))


# def main():
#     playing_game = True

#     while playing_game:
#         time.sleep(1)


# if __name__ == "__main__":
#     main()