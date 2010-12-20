package br.com.chapecosolucoes.trafegusweb.client.utils
{
    import mx.collections.XMLListCollection;
    import mx.rpc.events.ResultEvent;

    import org.hamcrest.collection.array;

    public class ParserResult
    {
        public function ParserResult()
        {
        }

        public static function parserDefault(e:ResultEvent):Array
        {
            var xml:XML = XML(e.result);
            var xmlListCollection:XMLListCollection = new XMLListCollection(xml.row);
            var result:Array = xmlListCollection.toArray();
            xml = null;
            xmlListCollection = null;
            return result;
        }
    }
}