#include<iostream>
#include<vector>
#include<set>
#include<math.h>
#include<algorithm>
#define long2 long long
#define vec vector<long2>
#define pair pair<long2, long2>
#define vecpair vector<pair>
#define set set<pair>
using namespace std;

void New_Graph(vecpair Graph[]){
    long2  edges , ver;
    cout << "No. of vertex in Topology: " ;
    cin >> ver;
    cout << "No. of edges in Topology: " ;
    cin >>edges;
    cout <<"Edges and Distance from the Vertex : \n";
    cout <<"(Starting vertex, Ending vertex, Distance)\n";
    for(int i=0;i<edges;i++){      
        long2 Start, End, Dist;
        cin >> Start >> End >>  Dist ;
        Graph[Start].push_back({End, Dist});
    }
}

void dijisktra_Algorithm(vec &dist, vecpair Graph[], long2 source, long2 destination_vertex, vec &parent) {
    set Distset;
    dist[source] = 0;
    Distset.insert({0, source});
    while (!Distset.empty()) {
        pair minimum_pair = *(Distset.begin());
        Distset.erase(Distset.begin());
        long2 Dist = minimum_pair.first;
        long2 ver = minimum_pair.second;
        for (auto &i : Graph[ver]) {
            if (Dist + i.second < dist[i.first]) {
                Distset.erase({ dist[i.first], i.first });
                Distset.insert({ Dist + i.second, i.first });
                dist[i.first] = Dist + i.second;
                parent[i.first] = ver;
            }
        }
    }
}

void print_path(vec &parent, long2 destination) {
    vec path;
    for (long2 v = destination; v != -1; v = parent[v]) {
        path.push_back(v);
    }
    reverse(path.begin(), path.end());
    cout << "The path from source to destination is: ";
    for (long2 v : path) {
        cout << v << " ";
    }
    cout << endl;
}

int main(){
    long2 PayL, MTU;
    vecpair Graph[10000];

    cout << "Enter the size Of Payload Including Header: ";
    cin >> PayL;
    PayL = PayL - 20;

    cout << "Enter the size Of MTU Including Header: ";
    cin >> MTU;
    MTU = MTU - 20;

    long2 fragment = (PayL + MTU - 1) / MTU;
    cout << "Fragments required to transmit Payload: " << fragment << endl;

    for (int i = 0; i < fragment; i++) {
        cout << "For " << i + 1 << " Fragment\n";
        char ch;
        if (i == 0) {
            ch = 'Y';
        }
        else {
            cout << "Do you want to change Topology(Y/N)? ";
            cin >> ch;
        }
        if (ch == 'Y') {
            New_Graph(Graph);
        }

        long2 source, dest;
        cout << "Source Vertex: " ;
        cin >> source;
        cout << "Destination Vertex: " ;
        cin>>dest;

        vec dist(10000, 1e18), parent(10000, -1);
        
        dijisktra_Algorithm(dist, Graph, source, dest, parent);
        cout << "The shortest distance from source to destination is: " << dist[dest] << endl;
        print_path(parent, dest);
      }
return 0;
}
