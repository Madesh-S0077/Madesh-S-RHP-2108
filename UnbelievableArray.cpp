#include<iostream>
#include<map>
#include<vector>
using namespace std;
int find(vector<int>& ldr,int key) {
    if(ldr[key] != key) {
        ldr[key] = find(ldr,ldr[key]);
    }
    return ldr[key];
}
void join(vector<int>& ldr, int lt,int rt) {
    ldr[find(ldr,lt)] = find(ldr,rt);
}
void solve() {
    int n,q;
    cin >> n >> q;
    vector<int> arr(n+1), ldr(n+1);
    map<int,int> vlm,lvm;
    for(int i = 1; i <= n; i++) {
        cin >> arr[i];
        if(vlm.find(arr[i]) == vlm.end()) {
            vlm[arr[i]] = i;
            lvm[i] = arr[i];
        }
        ldr[i] = vlm[arr[i]];
    }
    while(q--) {
        int choice; cin >> choice;
        if(choice == 1) {
            int x , y; cin >> x >> y;
            //if x and y are equal
            if(x == y) continue;
            // if x (val) is not present
            else if(vlm.find(x) == vlm.end()) continue;
            //cases y is present or not
            else if(vlm.find(y) != vlm.end()) {
                join(ldr,vlm[x],vlm[y]);
                lvm.erase(vlm[x]);
                vlm.erase(x);
            }
            else {
                int xldr = vlm[x];
                lvm[xldr] = y;
                vlm.erase(x);
                vlm[y] =  xldr;
            }
        }
        else {
            int idx; cin >> idx;
            cout << lvm[find(ldr,ldr[idx])] << endl;
        }
    }
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int tc;
    cin >> tc;
    int cases = 1;
    while(tc--) {
        cout << "Case " << cases++ << ":" << endl;
        solve();
    }
}