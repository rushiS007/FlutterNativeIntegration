import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class Cell extends StatefulWidget {
  Cell({Key? key}) : super(key: key);

  @override
  State<Cell> createState() => _CellState();
}

class _CellState extends State<Cell> {
  static const batteryChannel = MethodChannel('rushi.com/battery');
  String batteryLevel = 'Listening...';
  @override
  void initState() {
    super.initState();
    onListenBattery();
  }

  void onListenBattery() {
    batteryChannel.setMethodCallHandler((call) async {
      if (call.method == 'reportBatteryLevel') {
        final int batteryLevel = call.arguments;
        setState(() {
          this.batteryLevel = '$batteryLevel';
        });
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    return Scaffold(
      body: SafeArea(
          child: Container(
        color: Colors.white,
        alignment: Alignment.center,
        child: Text(
          batteryLevel,
          style: theme.textTheme.headline3,
        ),
      )),
    );
  }
}
