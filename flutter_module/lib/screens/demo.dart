import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class DemoScreen extends StatefulWidget {
  DemoScreen({Key? key}) : super(key: key);

  @override
  State<DemoScreen> createState() => _DemoScreenState();
}

class _DemoScreenState extends State<DemoScreen> {
  TextEditingController _textEditingController = TextEditingController();
  static const platform = MethodChannel('rushi.com/message');

  String text = "demo text";
  @override
  void initState() {
    super.initState();
    // onListenMessage();
  }

  Future<void> _sendMessage() async {
    var data = {'title':"Urgent",'message': text};
    try {
      var result = await platform.invokeMethod('sendMessage', data);
      print(result);
    } on PlatformException catch (e) {
      print("failed: ${e.message}");
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: 
      Container(
        color: Colors.amber,
        height: 300,
        child: Row(
          children: [
            Container(
                padding: const EdgeInsets.only(left: 30),
                width: 250,
                child: TextFormField(
                  decoration: const InputDecoration(
                    hintText: "Send to Native from Flutter",
                    hintStyle:  TextStyle(fontWeight: FontWeight.w700,color: Colors.black),
                    
                  ),
                  controller: _textEditingController,
                  scrollController: ScrollController(keepScrollOffset: false),
                ),
              ),
            IconButton(
                onPressed: () {
                  text = _textEditingController.text;
                  _sendMessage();
                },
                icon: const Icon(Icons.send))
          ],
        ),
      ),
      resizeToAvoidBottomInset: false,
    );
  }
}
