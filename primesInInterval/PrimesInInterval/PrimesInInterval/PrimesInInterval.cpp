#include<iostream>
using namespace std;


void primesInInterval(int from, int to)
{

	cout << "primesInInterval(" << from << "," << to << ") -> [";

	if (from > to || from <= 1 || to <= 1)
	{
		cout << "\b" << "invalid input" << endl;
		return;
	}

	bool prime = true;

	for (int i = from; i <= to; i++)
	{
		for (int j = 2; j < i; j++)
		{
			if (i % j == 0)
			{
				prime = false;
				break;
			}
		}
		if (prime)
		{
			cout << i<<",";
		}
		prime = true;
	}
	cout << "\b" << "]" << endl;
}

int main()
{
	int from, to;

	cout << "enter begin: ";
	cin >> from;

	if (!cin)
	{
		cout << "invalid input" << endl;
		return 1;
	}

	cout << "enter end: ";
	cin >> to;

	if (!cin)
	{
		cout << "invalid input"<< endl;
		return 1;
	}

	primesInInterval(from,to);

	return 0;
}