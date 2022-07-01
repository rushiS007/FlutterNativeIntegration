import 'package:flutter/material.dart';

class FlutterScreen extends StatelessWidget {
  const FlutterScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Text('This is flutter'),
      ),
    );
  }
}
