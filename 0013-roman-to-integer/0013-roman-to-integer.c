int romanToInt(char * s){
    int result=0;
    while(*s){
        switch(*s){
            case 'I': result += 1; break;
            case 'V': result += 5; break;
            case 'X': result += 10; break;
            case 'L': result += 50; break;
            case 'C': result += 100; break;
            case 'D': result += 500; break;
            case 'M': result += 1000; break;
            default: return -1;
        }
        if (s[1] != '\0') {
            if (*s == 'I' && (s[1] == 'V' || s[1] == 'X')) {
                result -= 2;
            } else if (*s == 'X' && (s[1] == 'L' || s[1] == 'C')) {
                result -= 20;
            } else if (*s == 'C' && (s[1] == 'D' || s[1] == 'M')) {
                result -= 200;
                
            }
        }
        s++;
    }
    return result;
}