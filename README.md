# bitmap-transformer

## What is bitmap-transformer

a project that reads a bmp image file and modify the image in more than one method

- ReverseBlackAndGreen : a method to convert all black color to green and the white color to black
- flipVertically : a method that flips the image upside down.
- random : a method that changes the color of the image randomly.


## How it works

- clone the repo and cd into `bitmap-transformer`
- on your terminal run `gradle run --args "inputFile outputFile transfromMethod"`.
    - Where the `inputfile is : the absloute path for your bmp image`
    - `outputFile : is the name of your modified image`
    -`transformerMethod : on of the method explained at the first of this readme file`
    - example `gradle run --args "D:\muhammad\test.bmp modified.bmp reverseblackandgreen"`

## Contributors
1. Mohammad Abushanab
2. Omar Al Issawi