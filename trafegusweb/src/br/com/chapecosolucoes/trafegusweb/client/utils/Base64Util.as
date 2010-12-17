package br.com.chapecosolucoes.trafegusweb.client.utils {
    import flash.utils.ByteArray;
    
    import mx.utils.Base64Decoder;
    import mx.utils.Base64Encoder;

    public class Base64Util {

        private var base64Encoder:Base64Encoder;
        private var base64Decoder:Base64Decoder;

        public function Base64Util() {
            base64Encoder = new Base64Encoder();
            base64Decoder = new Base64Decoder();
        }

        public function encodeString(value:String):String {
            base64Encoder.reset();
            base64Encoder.encode(value);
            return base64Encoder.toString();
        }

        public function decodeString(value:String):String {
            base64Decoder.reset();
            base64Decoder.decode(value);
            return base64Decoder.toByteArray().toString();
        }
        
        public function encodeBytes(value:ByteArray):String {
            base64Encoder.reset();
            base64Encoder.encodeBytes(value);
            return base64Encoder.toString();
        }
        
        public function decodeBytes(value:String):ByteArray {
            base64Decoder.reset();
            base64Decoder.decode(value);
            return base64Decoder.toByteArray();
        }
        

    }
}