import 'dart:ffi';

import 'package:flutter/material.dart';

void main() => runApp(MyApp());

List<Persona> personas = [
  Persona("Lilia Sarahi", "Trujillo", "20207947"),
  Persona("Daniel Omar", "Ramirez", "20207950"),
  Persona("Juan Manuel", "Olivares", "20207933"),
  Persona("Katia Mariela", "Benavides", "20207911"),
];

final nom = TextEditingController();
final ape = TextEditingController();
final cue = TextEditingController();

String tnom = '';
String tape = '';
String tcue = '';

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        debugShowCheckedModeBanner: false,
        title: 'Material App',
        home: MiPagina1());
  }
}

class MiPagina1 extends StatefulWidget {
  @override
  State<MiPagina1> createState() => _MiPagina1State();
}

class _MiPagina1State extends State<MiPagina1> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Listado de alumnos'),
      ),
      floatingActionButton: FloatingActionButton(
        backgroundColor: Colors.green,
        child: Icon(Icons.person_add),
        onPressed: () {
          Navigator.push(
              context,
              MaterialPageRoute(
                  builder: (BuildContext context) => MiPagina2()));
        },
      ),
      body: ListView.builder(
        itemCount: personas.length,
        itemBuilder: (BuildContext context, int index) {
          return ListTile(
            title: Text(personas[index].name + ' ' + personas[index].lastName),
            subtitle: Text(personas[index].cuenta),
            leading: CircleAvatar(
              child: Text(personas[index].name.substring(0, 1)),
            ),
            trailing: Icon(Icons.arrow_forward_ios),
          );
        },
      ),
    );
  }
}

class MiPagina2 extends StatefulWidget {
  @override
  State<MiPagina2> createState() => _MiPagina2State();
}

class _MiPagina2State extends State<MiPagina2> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Agregar alumno'),
      ),
      body: Center(
          child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Container(
            child: TextField(
              controller: nom,
              decoration: InputDecoration(
                  hintText: 'Nombre', filled: true, fillColor: Colors.white),
            ),
          ),
          SizedBox(height: 30.0),
          Container(
            child: TextField(
              controller: ape,
              decoration: InputDecoration(
                  hintText: 'Apellidos', filled: true, fillColor: Colors.white),
            ),
          ),
          SizedBox(height: 30.0),
          Container(
            child: TextField(
              controller: cue,
              decoration: InputDecoration(
                  hintText: 'No. cuenta',
                  filled: true,
                  fillColor: Colors.white),
            ),
          ),
          SizedBox(height: 50.0),
          Container(
              child: ElevatedButton(
                  onPressed: () {
                    tnom = nom.text;
                    tape = ape.text;
                    tcue = cue.text;
                    personas.add(Persona(tnom, tape, tcue));
                    Navigator.push(
                        context,
                        MaterialPageRoute(
                            builder: (BuildContext context) => MiPagina1()));
                  },
                  child: Text("Guardar"))
              /*flatButton(
              child: Text(
                'Guardar',
                style: TextStyle(fontSize: 25.0, color: Colors.white),
              ),
              color: Colors.green,
              onPressed: () {
                tnom = nom.text;
                tape = ape.text;
                tcue = cue.text;
                personas.add(Persona(tnom, tape, tcue));
                Navigator.push(
                    context,
                    MaterialPageRoute(
                        builder: (BuildContext context) => MiPagina1()));
              },
            ),*/
              ),
        ],
      )),
    );
  }
}

class Persona {
  String name;
  String lastName;
  String cuenta;

  Persona(this.name, this.lastName, this.cuenta);
}
      //theme: ThemeData(
        // This is the theme of your application.
        //
        // Try running your application with "flutter run". You'll see the
        // application has a blue toolbar. Then, without quitting the app, try
        // changing the primarySwatch below to Colors.green and then invoke
        // "hot reload" (press "r" in the console where you ran "flutter run",
        // or simply save your changes to "hot reload" in a Flutter IDE).
        // Notice that the counter didn't reset back to zero; the application
        // is not restarted.
/*     primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  // This widget is the home page of your application. It is stateful, meaning
  // that it has a State object (defined below) that contains fields that affect
  // how it looks.

  // This class is the configuration for the state. It holds the values (in this
  // case the title) provided by the parent (in this case the App widget) and
  // used by the build method of the State. Fields in a Widget subclass are
  // always marked "final".

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      // This call to setState tells the Flutter framework that something has
      // changed in this State, which causes it to rerun the build method below
      // so that the display can reflect the updated values. If we changed
      // _counter without calling setState(), then the build method would not be
      // called again, and so nothing would appear to happen.
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    //
    // The Flutter framework has been optimized to make rerunning build methods
    // fast, so that you can just rebuild anything that needs updating rather
    // than having to individually change instances of widgets.
    return Scaffold(
      appBar: AppBar(
        // Here we take the value from the MyHomePage object that was created by
        // the App.build method, and use it to set our appbar title.
        title: Text(widget.title),
      ),
      body: Center(
        // Center is a layout widget. It takes a single child and positions it
        // in the middle of the parent.
        child: Column(
          // Column is also a layout widget. It takes a list of children and
          // arranges them vertically. By default, it sizes itself to fit its
          // children horizontally, and tries to be as tall as its parent.
          //
          // Invoke "debug painting" (press "p" in the console, choose the
          // "Toggle Debug Paint" action from the Flutter Inspector in Android
          // Studio, or the "Toggle Debug Paint" command in Visual Studio Code)
          // to see the wireframe for each widget.
          //
          // Column has various properties to control how it sizes itself and
          // how it positions its children. Here we use mainAxisAlignment to
          // center the children vertically; the main axis here is the vertical
          // axis because Columns are vertical (the cross axis would be
          // horizontal).
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            const Text(
              'You have pushed the button this many times:',
            ),
            Text(
              '$_counter',
              style: Theme.of(context).textTheme.headlineMedium,
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: const Icon(Icons.add),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}

*/