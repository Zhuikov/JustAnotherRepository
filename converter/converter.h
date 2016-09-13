#ifndef CONVERTER_H
#define CONVERTER_H
#include <string>
#include <map>

class Converter
{
    const std::map< char, int > literals =
    {
        { '0',  0 },
        { '1',  1 },
        { '2',  2 },
        { '3',  3 },
        { '4',  4 },
        { '5',  5 },
        { '6',  6 },
        { '7',  7 },
        { '8',  8 },
        { '9',  9 },
        { 'A', 10 },
        { 'B', 11 },
        { 'C', 12 },
        { 'D', 13 },
        { 'E', 14 },
        { 'F', 15 }
    };

    int radixFrom = 0;
    int radixTo = 0;

    std::string integerPart = 0;
    std::string fractionalPart = 0;

    std::string convertIntegerPart();
    std::string convertFractionalPart();

public:

    Converter();
    std::string convert(std::string initialNumber, int radixFrom, int radixTo);
};

#endif // CONVERTER_H
