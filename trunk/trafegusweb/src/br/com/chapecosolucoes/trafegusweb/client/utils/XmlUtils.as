package br.com.chapecosolucoes.trafegusweb.client.utils
{
    import flash.xml.XMLDocument;
    import flash.xml.XMLNode;

    import mx.rpc.xml.SimpleXMLEncoder;

    public class XmlUtils
    {
        public function XmlUtils()
        {
        }

        public static function objectToXml(objSource:Object):String
        {
            var result:String;

            var qName:QName = new QName("results");
            var xmlDocument:XMLDocument = new XMLDocument();
            var simpleXMLEncoder:SimpleXMLEncoder = new SimpleXMLEncoder(xmlDocument);
            var xmlNode:XMLNode = simpleXMLEncoder.encodeValue(obj, qName, xmlDocument);
            var xml:XML = new XML(xmlDocument.toString());
            result = xml.toXMLString();

            qName = null;
            xmlDocument = null;
            simpleXMLEncoder = null;
            xmlNode = null;
            xml = null;

            return result;
        }
    }
}