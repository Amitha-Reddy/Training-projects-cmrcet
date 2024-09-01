#include <bits/stdc++.h>
using namespace std;

struct Account
{
    int userID;
    int balance;
};

bool compareByBalance(const Account &a, const Account &b)
{
    if (a.balance == b.balance)
        return a.userID < b.userID;
    return a.balance < b.balance;
}

int main()
{
    int numAccounts;
    cin >> numAccounts;
    vector<Account> accounts(numAccounts);
    unordered_map<int, int> userToIndex;

    for (int i = 0; i < numAccounts; ++i)
    {
        cin >> accounts[i].userID >> accounts[i].balance;
        userToIndex[accounts[i].userID] = i;
    }

    int numTransactions;
    cin >> numTransactions;

    for (int i = 0; i < numTransactions; ++i)
    {
        int senderID, receiverID, transferAmount;
        cin >> senderID >> receiverID >> transferAmount;

        int senderIndex = userToIndex[senderID];
        int receiverIndex = userToIndex[receiverID];

        if (accounts[senderIndex].balance >= transferAmount)
        {
            accounts[senderIndex].balance -= transferAmount;
            accounts[receiverIndex].balance += transferAmount;
            cout << "Success" << endl;
        }
        else
        {
            cout << "Failure" << endl;
        }
    }

    cout << endl;
    sort(accounts.begin(), accounts.end(), compareByBalance);
    for (const auto &account : accounts)
    {
        cout << account.userID << " " << account.balance << endl;
    }

    return 0;
}
