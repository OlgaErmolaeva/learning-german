<html>
<body>
<h1>Add new word and translation</h1>
<h2>${error}</h2>
<form method="post" action="/addWord">
<input type="text" name="germanWord" value="German word" onclick="this.value=''"/><br/>
<input type="text" name="translation"  value="Translation" onclick="this.value=''"/><br/>
<input type="text" name="synonym"  value="Synonym" onclick="this.value=''"/><br/>
<input type="submit" value="Add to vocabulary"/>
</form>
</body>
</html>
