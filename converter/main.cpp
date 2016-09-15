#include <iostream>
#include "converter.h"

int main()
{
    Converter converter;

    std::cout << converter.convert("111101,101", 2, 10) << std::endl;

    return 0;
}
