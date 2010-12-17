package br.com.fids.utils
{

    public class StrUtils
    {
        public function StrUtils()
        {
        }

        public static function limpar(str:String):String
        {
            if (str != null)
            {
                str = str.replace(/&/g, "");
                str = str.replace(/\'/g, ""); //'
                str = removeAll(str, "*", "");
                str = removeAll(str, "\t", "");
            }
            return str;
        }

        public static function rancaEnter(str:String):String
        {
            if (str != null)
            {
                str = str.replace(/\n/g, "");
                str = str.replace(String.fromCharCode(13), "");
            }
            return str;
        }

        public static function normalizeString(value:String):String
        {
            var patternTable:Object = new Object();
            patternTable["A"] = /À|Á|Â|Ã|Ä|Å/g;
            patternTable["E"] = /È|É|Ê|Ë/g;
            patternTable["I"] = /Ì|Í|Î|Ï/g;
            patternTable["O"] = /Ò|Ó|Ô|Õ|Ö/g;
            patternTable["U"] = /Ù|Ú|Û|Ü/g;
            patternTable["a"] = /à|á|â|ã|ä/g;
            patternTable["e"] = /è|é|ê|ë/g;
            patternTable["i"] = /ì|í|î|ï/g;
            patternTable["o"] = /ò|ó|ô|õ|ö/g;
            patternTable["u"] = /ù|ú|û|ü/g;
            patternTable["C"] = /Ç/g;
            patternTable["c"] = /ç/g;
            patternTable["N"] = /Ñ/g;
            patternTable["n"] = /ñ/g;
            var result:String = value;

            for (var letter:String in patternTable)
            {
                result = result.replace(patternTable[letter], letter);
            }
            result = result.replace(/´|`|~|^|¨/g, "");
            return result;
        }

        public static function somenteNumeros(value:String):String
        {
            var result:String = "";

            for (var a:int = 0; a < value.length; a++)
            {
                if (value.charCodeAt(a) >= 48 && (value.charCodeAt(a) <= 57))
                    result += value.charAt(a);
            }
            return result;
        }

        public static function removeAll(str:String, oque:String, peloque:String):String
        {
            var temp:String
            var j:int = 0;
            temp = str;
            j = temp.indexOf(oque);

            while (j > -1)
            {
                temp = temp.replace(oque, peloque);
                j = temp.indexOf(oque);
            }
            str = temp;
            temp = str
            return temp;
        }

        public static function removeFirst(value:String, removeStr:String):String
        {
            var result:String = value.replace(removeStr, "");
            return result;
        }

        public static function stripHtmlTags(html:String, tags:String = ""):String
        {
            var tagsToBeKept:Array = new Array();
            if (tags.length > 0)
            {
                tagsToBeKept = tags.split(new RegExp("\\s*,\\s*"));
            }
            var tagsToKeep:Array = new Array();
            for (var i:int = 0; i < tagsToBeKept.length; i++)
            {
                if (tagsToBeKept[i] != null && tagsToBeKept[i] != "")
                    tagsToKeep.push(tagsToBeKept[i]);
            }

            var toBeRemoved:Array = new Array();
            var tagRegExp:RegExp = new RegExp("<([^>\\s]+)(\\s[^>]+)*>", "g");
            var foundedStrings:Array = html.match(tagRegExp);
            for (i = 0; i < foundedStrings.length; i++)
            {
                var tagFlag:Boolean = false;
                if (tagsToKeep != null)
                {
                    for (var j:int = 0; j < tagsToKeep.length; j++)
                    {
                        var tmpRegExp:RegExp = new RegExp("<\/?" + tagsToKeep[j] + "[^<>]*?>", "i");
                        var tmpStr:String = foundedStrings[i] as String;
                        if (tmpStr.search(tmpRegExp) != -1)
                            tagFlag = true;
                    }
                }
                if (!tagFlag)
                    toBeRemoved.push(foundedStrings[i]);
            }
            for (i = 0; i < toBeRemoved.length; i++)
            {
                var tmpRE:RegExp = new RegExp("([\+\*\$\/])", "g");
                var tmpRemRE:RegExp = new RegExp((toBeRemoved[i] as String).replace(tmpRE, "\\$1"), "g");
                html = html.replace(tmpRemRE, "");
            }
            return html;
        }
    }
}