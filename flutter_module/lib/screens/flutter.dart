import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class FlutterScreen extends StatefulWidget {
  const FlutterScreen({Key? key}) : super(key: key);

  @override
  State<FlutterScreen> createState() => _FlutterScreenState();
}

class _FlutterScreenState extends State<FlutterScreen> {
  static const adderChannel = MethodChannel('rushi.com/addder');
  int counter = 0;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    onListenAdder();
  }

  void onListenAdder() {
    adderChannel.setMethodCallHandler((call) async {
      if (call.method == 'add') {
        final int cnt = call.arguments;
        setState(() {
          counter = cnt;
        });
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    return Scaffold(
      body: Center(
        child: FloatingActionButton(
            onPressed: () => setState(() {
                  counter++;
                  print("button pressed : $counter");
                }),
            child: Text(counter.toString())),
      ),
    );
  }
}
