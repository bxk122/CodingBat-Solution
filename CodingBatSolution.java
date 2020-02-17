//Given a string, if one or both of the first 2 chars is 'x', return the string without those 'x' chars, 
//and otherwise return the string unchanged. This is a little harder than it looks.
//Examples: 
//withoutX2("xHi") → "Hi"
//withoutX2("Hxi") → "Hi"
//withoutX2("Hi") → "Hi"
public String withoutX2(String str) 
{
  if(str.length()>=2) {
  if(str.charAt(0)=='x'&& str.charAt(1)=='x')
  {
    return str.substring(2,str.length());
  }
  if(str.charAt(0)=='x')
  {
    return str.substring(1,str.length());
  }
  if(str.charAt(1)=='x')
  {
    return str.substring(0,1)+str.substring(2,str.length());
  }
  }
  else if(str.length() == 1 && str.charAt(0)=='x')
  { 
    return "";
  }
  return str;
}

//Given 2 int arrays, a and b, of any length, return a new array with the first element of each array. 
//If either array is length 0, ignore that array.
//Examples:
//front11([1, 2, 3], [7, 9, 8]) → [1, 7]
//front11([1], [2]) → [1, 2]
//front11([1, 7], []) → [1]
public int[] front11(int[] a, int[] b)
{
  if(a.length > 0 && b.length > 0)
  {
    int[] newArray = {a[0],b[0]};
    return newArray;
  }
  else if(a.length == 0 && b.length == 0)
  {
   return b;
  }
  else if(a.length == 0)
  {
   int[] newArray = {b[0]};
   return newArray;
  }
  else if(b.length == 0)
  {
    int[] newArray = {a[0]};
    return newArray;
  }
 return a;
}
//Given an array of ints of even length, return a new array length 2 containing the middle two 
//elements from the original array. The original array will be length 2 or more.
//makeMiddle([1, 2, 3, 4]) → [2, 3]
//makeMiddle([7, 1, 2, 3, 4, 9]) → [2, 3]
//makeMiddle([1, 2]) → [1, 2]

public int[] makeMiddle(int[] nums) 
{
    int[] midArray = new int[2];
    int cool = nums.length/2;
    midArray[0] = nums[cool-1];
    midArray[1] = nums[cool];
    return midArray;
 
}


//Given three ints, a b c, return true if two or more of them have the same rightmost digit.
//The ints are non-negative. Note: the % "mod" operator computes the remainder, e.g. 17 % 10 is 7.
//lastDigit(23, 19, 13) → true
//lastDigit(23, 19, 12) → false
//lastDigit(23, 19, 3) → true
public boolean lastDigit(int a, int b, int c) 
{
  if(a%10 == b%10 || b%10==c%10 || a%10==c%10)
  {
    return true;
  }
  return false;
}

// Given 2 non-negative ints, a and b, return their sum, so long as the sum has the same number of
// digits as a. If the sum has more digits than a, just return a without b. (Note: one way to compute
// the number of digits of a non-negative int n is to convert it to a string with String.valueOf(n) and then 
// check the length of the string.)
// sumLimit(2, 3) → 5
// sumLimit(8, 3) → 8
// sumLimit(8, 1) → 9
public int sumLimit(int a, int b)
{
  int c = String.valueOf(a).length();
  int e = String.valueOf(a+b).length();
  if(e > c)
  {
    return a;
  }
  return a+b;
}

// Given a day of the week encoded as 0=Sun, 1=Mon, 2=Tue, ...6=Sat, and a boolean indicating 
// if we are on vacation, return a string of the form "7:00" indicating when the alarm clock should 
// ring. Weekdays, the alarm should be "7:00" and on the weekend it should be "10:00". Unless we are 
// on vacation -- then on weekdays it should be "10:00" and weekends it should be "off".
// alarmClock(1, false) → "7:00"
// alarmClock(5, false) → "7:00"
// alarmClock(0, false) → "10:00"

public String alarmClock(int day, boolean vacation)
{
  if(day >= 1 && day <= 5 && !vacation)
  {
    return "7:00";
  }
  if(vacation)
  {
    if(day >= 1 && day <=5)
    {
      return "10:00";
    }
    else
    {
      return "off";
    }
  }
  return "10:00";
}

// We want to make a row of bricks that is goal inches long. We have a number of small 
// bricks (1 inch each) and big bricks (5 inches each). Return true if it is possible to
// make the goal by choosing from the given bricks. This is a little harder than it looks
// and can be done without any loops. See also: Introduction to MakeBricks
// makeBricks(3, 1, 8) → true
// makeBricks(3, 1, 9) → false
// makeBricks(3, 2, 10) → true

public boolean makeBricks(int small, int big, int goal) 
{
  if((1 * small) + (5 * big) <  goal)
  {
    return false;
  }
  if(goal%5 <= (1*small))
  {
    return true;
  }
  return false;
}

// We want make a package of goal kilos of chocolate. We have small bars (1 kilo each) and 
// big bars (5 kilos each). Return the number of small bars to use, assuming we always use
// big bars before small bars. Return -1 if it can't be done.
// makeChocolate(4, 1, 9) → 4
// makeChocolate(4, 1, 10) → -1
// makeChocolate(4, 1, 7) → 2
public int makeChocolate(int small, int big, int goal)
{
	int maxBig = goal/5;
	if(maxBig <= big)
		goal -= maxBig*5;
	else
		goal -= big*5;
	if(goal <= small)
		return goal;
	return -1;
}

// Given three ints, a b c, return true if one of b or c is "close" (differing from a by at most 1),
// while the other is "far", differing from both other values by 2 or more. Note: Math.abs(num) computes
// the absolute value of a number.
// closeFar(1, 2, 10) → true
// closeFar(1, 2, 3) → false
// closeFar(4, 1, 3) → true
public boolean closeFar(int a, int b, int c) 
{
  if(Math.abs(a-b) <= 1 && (Math.abs(c-a)>=2 && Math.abs(c-b)>=2))
  {
    return true;
  }
  if(Math.abs(a-c) <= 1 && (Math.abs(b-a)>=2 && Math.abs(b-c)>=2))
  {
    return true;
  }
  return false;
}


// For this problem, we'll round an int value up to the next multiple of 10 if its rightmost 
//   digit is 5 or more, so 15 rounds up to 20. Alternately, round down to the previous multiple
//   of 10 if its rightmost digit is less than 5, so 12 rounds down to 10. Given 3 ints, a b c, 
// return the sum of their rounded values. To avoid code repetition, write a separate helper 
// "public int round10(int num) {" and call it 3 times. Write the helper entirely below and at
// the same indent level as roundSum().
// roundSum(16, 17, 18) → 60
// roundSum(12, 13, 14) → 30
// roundSum(6, 4, 4) → 10

public int round10(int num)
{
  if(num%10 < 5)
  {
    return Math.abs(num-num%10);
  }
  else
  {
    return ((num-num%10)+10);
  }
  
}
public int roundSum(int a, int b, int c) 
{
  return(round10(a)+round10(b)+round10(c));
}

// Given a string, return a string where for every char in the original, there are two chars.
// doubleChar("The") → "TThhee"
// doubleChar("AAbb") → "AAAAbbbb"
// doubleChar("Hi-There") → "HHii--TThheerree"
public String doubleChar(String str) 
{
  String k = "";
  for(int i = 0; i < str.length(); i++)
  {
    k = k + str.substring(i,i+1)+str.substring(i,i+1);
  }
  return k;
}

// Return true if the given string contains an appearance of "xyz" where the xyz is not 
// directly preceeded by a period (.). So "xxyz" counts but "x.xyz" does not.
// xyzThere("abcxyz") → true
// xyzThere("abc.xyz") → false
// xyzThere("xyz.abc") → true
public boolean xyzThere(String str) 
{
  for(int i = 0; i < str.length()-2; i++)
  {
    if(str.length()>=3)
    {
      if(str.substring(0,3).equals("xyz"))
      {
        return true;
      }
      if(str.substring(i,i+3).equals("xyz") && str.charAt(i-1)!='.')
      {
        return true;
      }
    }
  }
  return false;
}

// Given a string, consider the prefix string made of the first N chars of the string.
//  Does that prefix string appear somewhere else in the string? 
//   Assume that the string is not empty and that N is in the range 1..str.length().
// prefixAgain("abXYabc", 1) → true
// prefixAgain("abXYabc", 2) → true
// prefixAgain("abXYabc", 3) → false
public boolean prefixAgain(String str, int n)
{
  for(int i = n; i <= str.length()-n; i++)
  {
    if(str.substring(0,n).equals(str.substring(i,i+n)))
    {
      return true;
    }
  }
  return false;
}

// Given two strings, word and a separator sep, return a big string made of count occurrences of the word, 
// separated by the separator string.
// repeatSeparator("Word", "X", 3) → "WordXWordXWord"
// repeatSeparator("This", "And", 2) → "ThisAndThis"
// repeatSeparator("This", "And", 1) → "This"
public String repeatSeparator(String word, String sep, int count) 
{
  String k = "";
  for(int i = 0; i < count; i++)
  {
    k = k + word + sep;
  }
  return k.substring(0,k.length()-sep.length());
}

// Given a string, does "xyz" appear in the middle of the string? To define middle, we'll say that the number 
// of chars to the left and right of the "xyz" must differ by at most one. This problem is harder than it looks.
// xyzMiddle("AAxyzBB") → true
// xyzMiddle("AxyzBB") → true
// xyzMiddle("AxyzBBB") → false
public boolean xyzMiddle(String str) 
{
    int k = str.length()/2;
    if(str.length()%2 != 0&&str.length()>2)
    {
      if(str.charAt(k) == 'y' && str.charAt(k-1) == 'x' && str.charAt(k+1) == 'z')
      {
        return true;
      }
    }
    if(str.length()%2 == 0 && str.length()>2)
    {
      if(str.charAt(k) == 'y' && str.charAt(k-1) == 'x' && str.charAt(k+1) == 'z')
        {
          return true;
        }
      if(str.charAt(k) == 'z' && str.charAt(k-1) == 'y' && str.charAt(k-2) == 'x')
      {
        return true;
      }
    }
  
  return false;
}

// Returns true if for every '*' (star) in the string, if there are chars both immediately before and 
// after the star, they are the same.
// sameStarChar("xy*yzz") → true
// sameStarChar("xy*zzz") → false
// sameStarChar("*xa*az") → true
public boolean sameStarChar(String str) 
{
  for(int i = 1; i<str.length()-1; i++)
  {
    if(str.charAt(i)=='*' && (str.charAt(i-1)!=str.charAt(i+1)))
    {
     return false;
    }
  }
  return true;
}


// Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.
// bobThere("abcbob") → true
// bobThere("b9b") → true
// bobThere("bac") → false
public boolean bobThere(String str) 
{
  for(int i = 0; i < str.length()-2; i++)
  {
    if(str.substring(i,i+1).equals("b") && str.substring(i+2,i+3).equals("b"))
    {
      return true;
    }
  }
  return false;
}

// Return a version of the given string, where for every star (*) in the string the star and the 
// chars immediately to its left and right are gone. So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
// starOut("ab*cd") → "ad"
// starOut("ab**cd") → "ad"
// starOut("sm*eilly") → "silly"
public String starOut(String str) 
{
  String k = "";
  int len = str.length();
	int[] indexes = new int[len];
	// stbuild = new StringBuilder(len);
	for(int i = 0; i < len; i++)
	{
		if(str.charAt(i) == '*')
		{
			indexes[i] = 1;
			if(i >= 1)
				indexes[i-1] = 1;
			if(i < (len-1))
				indexes[i+1] = 1;
		}
	}
	for(int i = 0; i < len; i++)
	{
		if(indexes[i] == 0)
			k = k + str.charAt(i);
			//return k;
	}
	return k;
}
