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
        { 'a', 10 },
        { 'B', 11 },
        { 'b', 11 },
        { 'C', 12 },
        { 'c', 12 },
        { 'D', 13 },
        { 'd', 13 },
        { 'E', 14 },
        { 'e', 14 },
        { 'F', 15 },
        { 'f', 15 }
    };
    static const unsigned int accurate = 10;

    short int radixFrom;
    short int radixTo;
    std::string integerPart;
    std::string fractionalPart;

    std::string convertIntegerPart() const;
    std::string convertFractionalPart() const;
    char getKey(int value) const;

public:
    Converter():
        radixFrom(0),
        radixTo(0),
        integerPart(""),
        fractionalPart("")
    {}
    void convertWithConlose();
    std::string convert(const std::string initialNumber, const int radixFrom, const int radixTo);
};

#endif // CONVERTER_H
