package gomis.francisco.realizarappmonkeyfilm.network

import gomis.francisco.realizarappmonkeyfilm.data.MediaRepository

class MediaUseCase {
    val repository = MediaRepository()

    suspend operator fun invoke(filter: String): String {
        return repository.getMedia(filter)
    }
}