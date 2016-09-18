#include "converter.h"
#include <iostream>
#include <math.h>

void Converter::convertWithConlose()
{
    std::string inputNumber = "";
    std::string inputFrom = "";
    std::string inputTo = "";
    
    std::cout << "number: ";
    std::cin  >> inputNumber;
    std::cout << std::endl << "from: ";
    std::cin  >> inputFrom;
    std::cout << std::endl << "to: ";
    std::cin  >> inputTo;

    for (char item : inputNumber) {
        if ((item < '0' || item > '9') && (item < 'A' || item > 'F') && (item < 'a' || item > 'f')) {
            std::cout << "input error" << std::endl;
            return;
        }
    }

    for (char item : inputFrom) {
        if (item < '0' || item > '9') {
            std::cout << "input error" << std::endl;
            return;
        }
    }

    for (char item : inputTo) {
        if (item < '0' || item > '9') {
            std::cout << "input error" << std::endl;
            return;
        }
    }

    int from = atoi(inputFrom.c_str());
    int to = atoi(inputTo.c_str());

    std::cout << std::endl << inputNumber << " (" << inputFrom << ") = " <<
                 convert(inputNumber, from, to) << " (" << inputTo << ")" << std::endl;
}

std::string Converter::convert(const std::string number, const int radixFrom , const int radixTo)
{
    this->radixFrom = radixFrom;
    this->radixTo = radixTo;
    unsigned int i = 0;

    while (i < number.size() && number[i] != ',') {
        integerPart.push_back(number[i]);
        i++;
    }
    if (number[i] == ',') {
        isInteger = false;
        i++;
        while (i < number.size()) {
            fractionalPart.push_back(number[i]);
            i++;
        }
    }

    if (isInteger) {
        return convertIntegerPart();
    }
    return convertIntegerPart() + ',' + convertFractionalPart();
}

std::string Converter::convertIntegerPart()
{
    int numberRadix10 = 0;
    std::string reverseNumber = "";

    for (unsigned int i = 0; i < integerPart.size(); i++) {
        numberRadix10 += literals.at(integerPart[i]) * pow(radixFrom, integerPart.size() - 1 - i);
    }

    while (numberRadix10 >= radixTo) {
        reverseNumber.push_back(getKey(numberRadix10 % radixTo));
        numberRadix10 /= radixTo;
    }
    reverseNumber.push_back(getKey(numberRadix10));

    std::string result = "";
    for (int i = reverseNumber.length() - 1; i >= 0; i--){
        result.push_back(reverseNumber[i]);
    }

    return result;
}

std::string Converter::convertFractionalPart()
{
    double numberRadix10 = 0;
    std::string result = "";

    for (unsigned int i = 0; i < fractionalPart.size(); i++) {
        numberRadix10 += literals.at(fractionalPart[i]) * pow(radixFrom, ((int)i + 1) * (-1));
    }

    while (numberRadix10 >= 10e-7 && result.length() < accurate) {
        numberRadix10 *= radixTo;
        result.push_back(getKey((int)numberRadix10));
        numberRadix10 -= (int)numberRadix10;
    }

    return result;
}

char Converter::getKey(int value) const
{
    for (std::map< char, int >::const_iterator it = literals.begin(); it != literals.end(); ++it) {
        if ((*it).second == value) {
            return (*it).first;
        }
    }
    return '_';
}
