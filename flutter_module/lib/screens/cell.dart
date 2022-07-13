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
  int counter = 0;
  @override
  void initState() {
    super.initState();
    onListenBattery();
  }

  void onListenBattery() {
    batteryChannel.setMethodCallHandler((call) async {
      if (call.method == 'reportBatteryLevel') {
        final int batteryLvl = call.arguments;
        print(batteryLvl);
        setState(() {
          batteryLevel = '$batteryLvl';
          print("batteryLevel is $batteryLevel");
        });
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    return Scaffold(
        backgroundColor: Colors.amber,
        body: Center(
                child:Text(batteryLevel,style: theme.textTheme.headline6,)
            
        ),
        resizeToAvoidBottomInset: false,
    );
  }
}
