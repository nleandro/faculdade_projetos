import React, { useState } from 'react';
import { StyleSheet, Text, View, TextInput, Button } from 'react-native';

export default function App() {
  const [valorMin, setValorMin] = useState('1');
  const [valorMax, setValorMax] = useState('10');
  const [valorAleatorio, setValorAleatorio] = useState('Nenhum');

  function gerarNumero() {
    let min = parseInt(valorMin);
    let max = parseInt(valorMax);
    
    let random = randomInteger(min, max);

    setValorAleatorio(random);
  }

  function randomInteger(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }

  return (
    <View style={styles.container}>

      <Text style={styles.title}>Gerador de Números Aleatórios</Text>

      <View>
        <View style={styles.campos}>
          <Text style={styles.label}>Valor Mínimo:</Text>
          <TextInput
            style={styles.textInput}
            value={valorMin}
            onChangeText={numero => setValorMin(numero)}
            keyboardType='number-pad'
          />
        </View>

        <View style={styles.campos}>
          <Text style={styles.label}>Valor Máximo:</Text>
          <TextInput
            style={styles.textInput}
            value={valorMax}
            onChangeText={numero => setValorMax(numero)}
            keyboardType='number-pad'
          />
        </View>
      </View>

      <View style={styles.campoResultado}>
        <Button
          title='Gerar Número'
          onPress={() => gerarNumero()}
        />
        <Text style={styles.resultado}>O número gerado foi: {valorAleatorio}</Text>
      </View>

    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'space-around',
  },
  title: {
    fontSize: 22,
    textAlign: 'center',
    fontWeight: 'bold',
  },
  campos: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'center',
    marginVertical: 10,
  },
  label: {
    fontSize: 16,
  },
  textInput: {
    width: 100,
    borderWidth: 1,
    marginHorizontal: 10,
    paddingLeft: 8,
  },
  campoResultado: {
    width: '60%',
  },
  resultado: {
    marginTop: 20,
    fontSize: 18,
    textAlign: 'center',
  },
});
