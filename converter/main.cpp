#include <iostream>
#include "converter.h"

int main()
{
    Converter converter;

    std::cout << converter.convert("ABCD33", 16, 2) << std::endl;

    return 0;
}
