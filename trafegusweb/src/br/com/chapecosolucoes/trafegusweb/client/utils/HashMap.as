package br.com.chapecosolucoes.trafegusweb.client.utils {
    import flash.utils.Dictionary;

    public class HashMap {
        private var map:Dictionary = null;

        public function HashMap() {
            map = new Dictionary();
        }

        public function put(key:*,value:*):void {
            map[key] = value;
        }

        public function remove(key:*):void {
            delete map[key];
        }

        public function containsKey(key:*):Boolean {
            return map.hasOwnProperty(key);
        }

        public function containsValue(value:*):Boolean {
            var result:Boolean = false;
            for (var key:*in map) {
                if (map[key]==value) {
                    result = true;
                    break;
                }
            }
            return result;
        }

        public function getKey(value:*):* {
            var id:String = null;
            for (var key:*in map) {
                if (map[key]==value) {
                    id = key;
                    break;
                }
            }
            return id;
        }
        
        public function getKeyByIndex(index:int):* {
        	var co:int = -1;
            for (var key:* in map) {
                co++;
                if (co == index) return key;
            }
            return null;
        }

        public function getValue(key:*):* {
            return map[key];
        }

        public function size():int {
            var length:int = 0;

            for (var key:*in map) {
                length++;
            }
            return length;
        }

        public function isEmpty():Boolean {
            return size()<=0;
        }

        public function clear():void {
            for (var key:*in map) {
                remove(key);
            }
        }
        
        public function getAllKeys():Array {
        	var result:Array = new Array();
            for (var key:*in map)
            	result.push(key);
        	return result;
        }
        public function toString():String {
        	var str:String = "";
        	var arr:Array = getAllKeys();
        	for (var i:int = 0;i<arr.length;i++) {
        		str += arr[i]+" - "+getValue(arr[i])+"\n";
        	}
        	return str;
        }
    }
}