import React from 'react';
import {
  View,
  SafeAreaView,
  FlatList,
  Image,
  StyleSheet,
  Text,
  TouchableOpacity
} from 'react-native';

import options from '../../../assets/options.png';
import like from '../../../assets/like.png';
import comment from '../../../assets/comment.png';
import send from '../../../assets/send.png';
import save from '../../../assets/save.png';

export default function Feed() {

  const posts = [
    {
      id: '1',
      author: 'sky_high_architecture',
      picture_url: 'https://scontent-gru2-1.cdninstagram.com/v/t51.2885-15/e35/p1080x1080/97335517_583240262395664_7960157320046072507_n.jpg?_nc_ht=scontent-gru2-1.cdninstagram.com&_nc_cat=108&_nc_ohc=06Zg2Tqi8A8AX-CQJVj&oh=1fc7ebb36b6f05018ba8544218069a08&oe=5EEC98BB&dl=1',
      likes: 2548,
      description: 'Capture the essence',
      hashtags: '#Sky_High_Architecture #architecture_hunter #archi #archidaily',
      place: 'Suzhou, Jiangsu'
    },
    {
      id: '2',
      author: 'sky_high_architecture',
      picture_url: 'https://scontent-ort2-1.cdninstagram.com/v/t51.2885-15/e35/p1080x1080/97354414_561038491456446_4568653426603928545_n.jpg?_nc_ht=scontent-ort2-1.cdninstagram.com&_nc_cat=1&_nc_ohc=ddXoS47rlOIAX_qfLUq&oh=c5ae826e717d9c8a6c6c1945efe0729c&oe=5EEA8CA2',
      likes: 5871,
      description: 'Capture the essence',
      hashtags: '#Sky_High_Architecture #architecture_hunter #archi #archidaily',
      place: 'Ferrari World Abu Dhabi'
    },
    {
      id: '3',
      author: 'sky_high_architecture',
      picture_url: 'https://scontent-ort2-1.cdninstagram.com/v/t51.2885-15/e35/p1080x1080/94228497_321549422154934_5956386940971347523_n.jpg?_nc_ht=scontent-ort2-1.cdninstagram.com&_nc_cat=110&_nc_ohc=daq0EezZj_kAX8tc0cv&oh=2c32205b53dba67f810517844fa19c11&oe=5EEA32CB',
      likes: 2396,
      description: 'Capture the essence',
      hashtags: '#Sky_High_Architecture #architecture_hunter #archi #archidaily',
      place: 'Kuala Lumpur, Malaysia'
    },
    {
      id: '4',
      author: 'sky_high_architecture',
      picture_url: 'https://scontent-ort2-1.cdninstagram.com/v/t51.2885-15/e35/p1080x1080/92543751_121791826135913_288357809357838417_n.jpg?_nc_ht=scontent-ort2-1.cdninstagram.com&_nc_cat=105&_nc_ohc=-Dvmk6KgAG0AX8L8V6z&oh=9202ec161dcf5c84a125eede00198032&oe=5EE9AC4E',
      likes: 7582,
      description: 'Capture the essence',
      hashtags: '#Sky_High_Architecture #architecture_hunter #archi #archidaily',
      place: 'Nanjing, China'
    },
  ];

  function renderItem({ item: post }) {
    return (
      <View style={styles.post}>

        <View style={styles.postHeader}>
          <View style={styles.userInfo}>
            <Text style={styles.author}>{post.author}</Text>
            <Text style={styles.place}>{post.place}</Text>
          </View>

          <View style={styles.postOptions}>
            <TouchableOpacity>
              <Image source={options} />
            </TouchableOpacity>
          </View>
        </View>

        <View>
          <Image
            style={styles.picture_url}
            source={{ uri: post.picture_url }}
          />
        </View>

        <View style={styles.footer}>
          <View style={styles.actions}>
            <View style={styles.leftActions}>
              <TouchableOpacity style={styles.action}>
                <Image source={like} />
              </TouchableOpacity>
              <TouchableOpacity style={styles.action}>
                <Image source={comment} />
              </TouchableOpacity>
              <TouchableOpacity>
                <Image source={send} />
              </TouchableOpacity>
            </View>

            <View>
              <TouchableOpacity>
                <Image source={save} />
              </TouchableOpacity>
            </View>
          </View>

          <View>
            <Text style={styles.likes}>{post.likes} likes</Text>
            <Text style={styles.hashtags}>{post.hashtags}</Text>
            <Text style={styles.description}>{post.description}</Text>
          </View>
        </View>

      </View>
    );
  }

  return (
    <SafeAreaView>
      <FlatList
        data={posts}
        keyExtractor={item => item.id}
        renderItem={renderItem}
      />
    </SafeAreaView>
  );

};

const styles = StyleSheet.create({
  post: {
    marginVertical: 15
  },
  postHeader: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    paddingHorizontal: 15,
    alignItems: 'center',
    marginBottom: 15
  },
  postOptions: {},
  userInfo: {},
  author: {
    fontSize: 14,
    color: '#000',
    fontWeight: 'bold'
  },
  place: {
    fontSize: 12,
    color: '#666'
  },
  picture_url: {
    width: '100%',
    height: 400
  },
  footer: {
    paddingHorizontal: 15
  },
  actions: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    paddingVertical: 15
  },
  action: {
    marginRight: 8
  },
  leftActions: {
    flexDirection: 'row'
  },
  likes: {
    fontWeight: 'bold',
    fontSize: 12
  },
  hashtags: {
    color: '#002D5E'
  },
  description: {
    color: '#000',
    lineHeight: 18
  }
});