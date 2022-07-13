import 'package:flutter/material.dart';

class Secret extends StatelessWidget {
  const Secret({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    return Scaffold(
      body: Center(
        child: Text("3", style: theme.textTheme.headline3,),
      ),
    );
  }
}
