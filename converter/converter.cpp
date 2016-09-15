#include "converter.h"
#include <iostream>
#include <math.h>

char Converter::getKey(int value) const
{
    for (std::map< char, int >::const_iterator it = literals.begin(); it != literals.end(); ++it) {
        if ((*it).second == value) {
            return (*it).first;
        }
    }
    return '0';
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
        i++;
        while (i < number.size()) {
            fractionalPart.push_back(number[i]);
            i++;
        }
    }

    convertFractionalPart();
    return convertIntegerPart();
}

std::string Converter::convertIntegerPart()
{
    int numberRadix10 = 0;
    std::string reverseNumber = "";

    for (unsigned int i = 0; i < integerPart.size(); i++) {
        numberRadix10 += literals.at(integerPart[i]) * (pow(radixFrom, integerPart.size() - 1 - i));
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
    std::string reverseNumber = "";

    for (int i = 0; i < fractionalPart.size(); i++) {
        std::cout << pow(radixFrom, -i - 1) << std::endl;
//        numberRadix10 += literals.at(fractionalPart[i]) * (pow(radixFrom, (-1) * (i + 1)));
    }

    std::cout << numberRadix10 << std::endl;
}
