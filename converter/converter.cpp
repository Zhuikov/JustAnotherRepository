#include "converter.h"

std::string Converter::convert(const std::string number, const int radixFrom , const int radixTo)
{
    this->radixFrom = radixFrom;
    this->radixTo = radixTo;
    unsigned int i = 0;

    while (i < number.size() || number[i] != ',') {
        integerPart += number[i];
        i++;
    }

    if (number[i] == ',') {
        i++;
        while (i < number.size()) {
            fractionalPart += number[i];
            i++;
        }
    }
}

std::string Converter::convertIntegerPart()
{
    for (unsigned int i = 0; i < integerPart.size(); i++) {

    }
}
