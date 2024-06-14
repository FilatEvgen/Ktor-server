import data_model.GameCards
import database.Database

object GameRepository {
    fun getHotGames(): List<GameCards> {
        val connection = Database.getConnection()
        val statement = connection?.prepareStatement("SELECT * FROM public.game_cards LIMIT 150")
        val resultSet = statement?.executeQuery()

        val games = mutableListOf<GameCards>()
        while (resultSet?.next() == true) {
            games.add(GameCards(resultSet.getString("image"),resultSet.getString("title"),resultSet.getString("link"),resultSet.getString("icon"),resultSet.getFloat("rating")))
        }

        connection?.close()
        return games
    }
}