

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope



import com.paulo.indicatorprogress.clean.data.repository.PersonRepository
import com.paulo.indicatorprogress.clean.domain.FilterPersonsUseCase
import com.paulo.indicatorprogress.clean.presentation.mapper.toPerson
import com.paulo.indicatorprogress.clean.presentation.state.PersonUIItem
import kotlinx.coroutines.launch

class MainViewModel(
    private val personRepository: PersonRepository = PersonRepository(filterPersonsUseCase = FilterPersonsUseCase())
) : ViewModel() {

    var persons by mutableStateOf<List<PersonUIItem>>(emptyList())

    var newInsertedPersons = mutableStateListOf<PersonUIItem>()

    init {
        initPersonItems()
    }

    private fun initPersonItems(){
        viewModelScope.launch {
            /*persons = personRepository.getPersons().map {
                it.toPersonUIItem()
            }*/
        }
    }

    fun addNewInsertedPersons(){
        viewModelScope.launch {
            personRepository.insertPersons(
                newInsertedPersons.toList().map {
                    it.toPerson()
                }
            )
        }
    }
}